using System.IO;
using System.Security.Cryptography.X509Certificates; // 添加此命名空间
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using Path = System.IO.Path;
using System.Text.Json;
namespace fabricfz
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        // 明确指定不带 BOM 的 UTF-8 编码
        private static readonly UTF8Encoding Utf8NoBom = new UTF8Encoding(false);

        public MainWindow()
        {
            InitializeComponent();
        }

        public string directoryPath = @"D:\Desktop\lightseekingnext\src\main"; // 定义目录路径
        public string javaPath = @"D:\Desktop\lightseekingnext\src\main\java\lsk\lightseekingnext"; // 定义目录路径
        //  public string resourcesPath = @"D:\Desktop\lightseekingnext\src\main\java\lsk\lightseekingnext"; // 定义目录路径

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            string namespac = tx1.Text;
            string name = tx2.Text;
            string lang = langa.Text;
            string fileName = $"{name}.java";
            string filePath = Path.Combine(javaPath + @".\moditems", fileName);

            if (!Directory.Exists(directoryPath))
            {
                Directory.CreateDirectory(directoryPath);
            }

            // 使用@字符串写入多行Java代码
            string javaCode =
            $@"package lsk.lightseekingnext.moditems;

import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class {name} {{


    public static <T extends Item> T register(String path, T item) {{
        return Registry.register(Registries.ITEM,new Identifier(""{namespac}"", path), item);
    }}

    //物品注册开始
    public static final Item {name} = register(""{name}"", new Item(new Item.Settings()));
    public static void initialize() {{
    }}
}}
";

            SafeWriteAllText(filePath, javaCode);
            InsertInitializeCall($"{javaPath}" + @".\Lightseekingnext.java", $"{name}");
            langinjure($"{directoryPath}" + $@"\resources\assets\{namespac}\lang\zh_cn.json", $"{name}", lang, "item");
            modelsinjure($"{directoryPath}" + $@"\resources\assets\{namespac}\models\item\{name}.json", $"{name}", "null", "item");
            MessageBox.Show("文件已生成：" + filePath, "提示");
        }

        private void langinjure(string targetJsonFile, string className, string fanyi, string type)
        {
            // 1. 读取原有 JSON 文件内容，如果不存在则新建空对象
            Dictionary<string, string> dict;
            if (File.Exists(targetJsonFile))
            {
                string json = File.ReadAllText(targetJsonFile, Utf8NoBom);
                dict = JsonSerializer.Deserialize<Dictionary<string, string>>(json) ?? new Dictionary<string, string>();
            }
            else
            {
                dict = new Dictionary<string, string>();
            }

            // 2. 生成要插入的 key
            string key = type switch
            {
                "item" => $"item.lightseeking.{className}",
                "block" => $"block.lightseeking.{className}",
                "entity" => $"entity.lightseeking.{className}",
                _ => className
            };

            // 3. 添加或更新 key
            dict[key] = fanyi;

            // 4. 写回 JSON 文件，格式化输出
            var options = new JsonSerializerOptions { WriteIndented = true };
            string newJson = JsonSerializer.Serialize(dict, options);
            SafeWriteAllText(targetJsonFile, newJson);
        }

        private void blockstates(string targetJavaFile, string className, string fanyi, string type)
        {
            string[] lines = File.ReadAllLines(targetJavaFile, Utf8NoBom);
            var newLines = new List<string>();
            bool inOnInitialize = false;
            int braceCount = 0;
            int insertIndex = -1;

            // 先遍历，找到 onInitialize 方法体的结束位置
            for (int i = 0; i < lines.Length; i++)
            {
                string line = lines[i];
                newLines.Add(line);

                if (!inOnInitialize && line.Contains("void onInitialize()"))
                {
                    inOnInitialize = true;
                }

                if (inOnInitialize)
                {
                    if (line.Contains("{")) braceCount++;
                    if (line.Contains("}")) braceCount--;

                    // 当 braceCount==0 时，说明方法体结束，记录插入点
                    if (braceCount == 0)
                    {
                        insertIndex = i;
                        inOnInitialize = false;
                    }
                }
            }

            // 在 insertIndex 前一行插入初始化语句（即方法体最后一个 } 之前）
            if (insertIndex > 0)
            {
                newLines.Insert(insertIndex, $@"{{
  ""variants"": {{
    """": {{ ""model"": ""lightseeking:block/{className}"" }}
  }}
}} ");
            }

            SafeWriteAllLines(targetJavaFile, newLines);
        }

        private void modelsinjure(string targetJavaFile, string className, string fanyi, string type)
        {
            string lineToWrite = string.Empty;

            if (type == "item")
            {
                lineToWrite = $@"{{
  ""parent"": ""item/generated"",
  ""textures"": {{
    ""layer0"": ""lightseeking:item/{className}""
  }}
}}";
            }
            else if (type == "block")
            {
                lineToWrite = $@"{{
  ""parent"": ""block/cube_all"",
  ""textures"": {{
    ""all"": ""lightseeking:block/{className}""
  }}
}}   ";
            }

            SafeWriteAllLines(targetJavaFile, new[] { lineToWrite });
        }

        private void InsertInitializeCall(string targetJavaFile, string className)
        {
            string[] lines = File.ReadAllLines(targetJavaFile, Utf8NoBom);
            var newLines = new List<string>();
            bool inOnInitialize = false;
            int braceCount = 0;
            int insertIndex = -1;

            // 先遍历，找到 onInitialize 方法体的结束位置
            for (int i = 0; i < lines.Length; i++)
            {
                string line = lines[i];
                newLines.Add(line);

                if (!inOnInitialize && line.Contains("void onInitialize()"))
                {
                    inOnInitialize = true;
                }

                if (inOnInitialize)
                {
                    if (line.Contains("{")) braceCount++;
                    if (line.Contains("}")) braceCount--;

                    // 当 braceCount==0 时，说明方法体结束，记录插入点
                    if (braceCount == 0)
                    {
                        insertIndex = i;
                        inOnInitialize = false;
                    }
                }
            }

            // 在 insertIndex 前一行插入初始化语句（即方法体最后一个 } 之前）
            if (insertIndex > 0)
            {
                newLines.Insert(insertIndex, $"        {className}.initialize();");
            }

            SafeWriteAllLines(targetJavaFile, newLines);
        }

        private void SafeWriteAllText(string filePath, string content)
        {
            string? dir = Path.GetDirectoryName(filePath);
            if (!string.IsNullOrEmpty(dir))
                Directory.CreateDirectory(dir);
            File.WriteAllText(filePath, content, Utf8NoBom);
        }

        private void SafeWriteAllLines(string filePath, IEnumerable<string> lines)
        {
            string? dir = Path.GetDirectoryName(filePath);
            if (!string.IsNullOrEmpty(dir))
                Directory.CreateDirectory(dir);
            File.WriteAllLines(filePath, lines, Utf8NoBom);
        }
    }
}
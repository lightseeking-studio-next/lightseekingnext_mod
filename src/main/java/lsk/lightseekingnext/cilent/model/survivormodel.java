package lsk.lightseekingnext.cilent.model;

import lsk.lightseekingnext.entity.survivor;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class survivormodel extends EntityModel<survivor> {
    private final ModelPart base;
    public static final EntityModelLayer LAYER_LOCATION = new EntityModelLayer(new Identifier("survivor"), "textures/entity/survivor.png");
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartBuilder builder = ModelPartBuilder.create()
                .uv(0, 0)
                .cuboid(-6.0F, 0.0F, -6.0F, 12.0F, 12.0F, 12.0F); // 定义立方体的大小

        modelPartData.addChild(EntityModelPartNames.CUBE,
                builder,
                ModelTransform.pivot(0.0F, 0.0F, 0.0F)); // 设置模型的中心点

        return TexturedModelData.of(modelData, 64, 64); // 设置纹理大小
    }

    public survivormodel(ModelPart modelPart) {
        this.base = modelPart.getChild(EntityModelPartNames.CUBE); // 正确地从传入的 modelPart 获取子部件
    }

    @Override
    public void setAngles(survivor entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // 可以添加动画逻辑
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        // translate model down
        matrices.translate(0, 1.125, 0);

        // render cube
        this.base.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}

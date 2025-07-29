package lsk.lightseekingnext.cilent.renderer;



import lsk.lightseekingnext.cilent.model.survivormodel;
import lsk.lightseekingnext.entity.survivor;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/*
 * A renderer is used to provide an entity model, shadow size, and texture.
 */
public class survivorrenderer extends MobEntityRenderer<survivor, survivormodel> {

    public survivorrenderer(EntityRendererFactory.Context context) {
        super(context, new survivormodel(context.getPart(survivormodel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public Identifier getTexture(survivor entity) {
        return new Identifier("entitytesting", "textures/entity/cube/cube.png");
    }
}



package entity;

import entity.sign.Attributes;
import entity.sign.Constants;
import entity.sign.Retrieves;
import entity.sign.Transforms;

/**
 * 基调单元
 *
 * @author Duyining
 * @date 2019/8/2
 */
public class Signature {
    private Attributes attributes;
    private Constants constants;
    private Retrieves retrieves;
    private Transforms transforms;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Constants getConstants() {
        return constants;
    }

    public void setConstants(Constants constants) {
        this.constants = constants;
    }

    public Retrieves getRetrieves() {
        return retrieves;
    }

    public void setRetrieves(Retrieves retrieves) {
        this.retrieves = retrieves;
    }

    public Transforms getTransforms() {
        return transforms;
    }

    public void setTransforms(Transforms transforms) {
        this.transforms = transforms;
    }

    @Override
    public String toString() {
        return "Signature{" +
                "attributes=" + attributes +
                ", constants=" + constants +
                ", retrieves=" + retrieves +
                ", transforms=" + transforms +
                '}';
    }
}

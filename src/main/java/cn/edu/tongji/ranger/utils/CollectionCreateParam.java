package cn.edu.tongji.ranger.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Dai on 6/19/16.
 */
public class CollectionCreateParam {
    @JsonProperty("product_id")
    long productId;

    @JsonProperty("angency_id")
    long angencyId;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getAngencyId() {
        return angencyId;
    }

    public void setAngencyId(long angencyId) {
        this.angencyId = angencyId;
    }

    @Override
    public String toString() {
        return "CollectionCreateParam{" +
                "productId=" + productId +
                ", angencyId=" + angencyId +
                '}';
    }
}

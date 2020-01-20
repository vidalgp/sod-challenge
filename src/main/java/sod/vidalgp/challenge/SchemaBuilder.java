package sod.vidalgp.challenge;

import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

public class SchemaBuilder {

    StructType schema;

    final static public StructType getSchema(StructType structType) {
        structType = structType.add("id_search", DataTypes.StringType, true);
        structType = structType.add("label", DataTypes.StringType, true);
        structType = structType.add("id_user", DataTypes.StringType, true);
        structType = structType.add("id_product", DataTypes.StringType, true);
        structType = structType.add("ts_search", DataTypes.StringType, true);
        structType = structType.add("ds_search", DataTypes.StringType, true);
        structType = structType.add("ds_purchased", DataTypes.StringType, true);
        structType = structType.add("ds_cart", DataTypes.StringType, true);
        structType = structType.add("query_market", DataTypes.StringType, true);
        structType = structType.add("query_delivery_date_start", DataTypes.StringType, true);
        structType = structType.add("query_delivery_end_date", DataTypes.StringType, true);
        structType = structType.add("query_delivery_radius", DataTypes.DoubleType, true);
        structType = structType.add("query_price_max", DataTypes.DoubleType, true);
        structType = structType.add("query_price_min", DataTypes.IntegerType, true);
        structType = structType.add("product_is_new", DataTypes.IntegerType, true);
        structType = structType.add("product_total_price", DataTypes.DoubleType, true);
        structType = structType.add("product_review_rating", DataTypes.DoubleType, true);
        structType = structType.add("product_review_count", DataTypes.DoubleType, true);
        structType = structType.add("product_type", DataTypes.DoubleType, true);
        structType = structType.add("product_recommended_items", DataTypes.IntegerType, true);
        structType = structType.add("product_has_video", DataTypes.BooleanType, true);
        structType = structType.add("product_recent_comments_count", DataTypes.IntegerType, true);
        structType = structType.add("product_recent_comments_count_90d", DataTypes.DoubleType, true);
        structType = structType.add("product_volume_discount", DataTypes.IntegerType, true);
        structType = structType.add("product_bundle_discount", DataTypes.IntegerType, true);
        structType = structType.add("product_short_term_price_factor", DataTypes.StringType, true);
        structType = structType.add("product_long_term_price_factor", DataTypes.DoubleType, true);
        
        return structType;
    }
}

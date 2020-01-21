package sod.vidalgp.challenge;

import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.Column;
import org.apache.spark.sql.types.DataTypes;

import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.expressions.UserDefinedFunction;

public class SchemaFixer {

    static private UserDefinedFunction dateFixer = udf(
        (String ss) -> {
            if (ss != null) {
                if (ss.length() == 8) {
                    return ss;
                } else if (ss.matches("^\\d{2}/\\d{1}/\\d{2}$")) {
                    String pattern = "^(\\d{2}/)(\\d{1})(/\\d{2})$";
                    return ss.replaceAll(pattern, "$1"+"0$2"+"$3");
                } else if (ss.matches("^\\d{1}/\\d{1}/\\d{2}$")) {
                    String pattern = "^(\\d{1}/)(\\d{1})(/\\d{2})$";
                    return ss.replaceAll(pattern, "0$1"+"0$2"+"$3");
                } else if (ss.matches("^\\d{1}/\\d{2}/\\d{2}$")) {
                    String pattern = "^(\\d{1}/)(\\d{2})(/\\d{2})$";
                    return ss.replaceAll(pattern, "0$1"+"$2"+"$3");
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }, DataTypes.StringType
    );

    static public Dataset<SearchData> fixSchema(Dataset<Row> df_0) {
        Dataset<Row> df_1 = df_0
            .withColumn("ts_search"
                ,when(col("ts_search").rlike("^.*\\d{2}:\\d{2}$"), to_timestamp(col("ts_search"), "MM/dd/yy HH:mm"))
                .when(col("ts_search").rlike("^.*\\s\\d{1}:\\d{2}$"), to_timestamp(col("ts_search"), "MM/dd/yy H:mm")))
            .withColumn("ds_search", to_date(dateFixer.apply(col("ds_search")), "MM/dd/yy"))
            .withColumn("ds_purchased", to_date(dateFixer.apply(col("ds_purchased")), "MM/dd/yy"))
            .withColumn("ds_cart", to_date(dateFixer.apply(col("ds_cart")), "MM/dd/yy"))
            .withColumn("query_delivery_date_start", to_date(dateFixer.apply(col("query_delivery_date_start")), "MM/dd/yy"))
            .withColumn("query_delivery_end_date", to_date(dateFixer.apply(col("query_delivery_end_date")), "MM/dd/yy"))
            .withColumn("query_price_max", col("query_price_max").cast(DataTypes.IntegerType))
            .withColumn("query_price_min", col("query_price_min").cast(DataTypes.IntegerType))
            .withColumn("product_review_count", col("product_review_count").cast(DataTypes.IntegerType))
            .withColumn("product_type", col("product_type").cast(DataTypes.IntegerType))
            .withColumn("product_recommended_items", col("product_recommended_items").cast(DataTypes.IntegerType))
            .withColumn("product_recent_comments_count_90d", col("product_recent_comments_count_90d").cast(DataTypes.IntegerType))
            .withColumn("product_short_term_price_factor"
                ,when(not(col("product_short_term_price_factor").rlike("[0-9].*")), null)
                .otherwise(col("product_short_term_price_factor"))
                .cast(DataTypes.DoubleType));

        Dataset<SearchData> ds = df_1.as(Encoders.bean(SearchData.class));
        
        return ds;
    }


} 
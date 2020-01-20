package sod.vidalgp.challenge;

import java.sql.Date;
import java.sql.Timestamp;

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

    static public Dataset<Row> fixSchema(Dataset<Row> df_0) {
    // static public Dataset<SearchData> fixSchema(Dataset<Row> df_0) {
        Dataset<Row> df_1 = df_0
            .withColumn("ts_search"
                ,when(col("ts_search").rlike("^.*\\d{2}:\\d{2}$"), to_date(col("ts_search"), "MM/dd/yy HH:mm"))
                .when(col("ts_search").rlike("^.*\\s\\d{1}:\\d{2}$"), to_date(col("ts_search"), "MM/dd/yy H:mm")))
            .withColumn("ds_cart", to_date(dateFixer.apply(col("ds_cart")), "MM/dd/yy"))
            .withColumn("ds_purchased", to_date(dateFixer.apply(col("ds_purchased")), "MM/dd/yy"))
            .withColumn("query_delivery_end_date", to_date(dateFixer.apply(col("query_delivery_end_date")), "MM/dd/yy"))
            .filter(col("ts_search").isNotNull())
            .filter(col("query_delivery_end_date").isNotNull())
            .filter(col("ds_cart").isNotNull());
                    
        df_1.printSchema();
        df_1.select("ds_cart", "ts_search", "query_delivery_end_date").show();
        return df_1;
    }


} 
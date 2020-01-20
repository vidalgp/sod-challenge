package sod.vidalgp.challenge;

import java.io.IOException;
import java.util.Objects;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.Column;

import static org.apache.spark.sql.functions.*;
import org.apache.spark.sql.types.StructType;

import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;


public class DataHandler {
  void importData(String inputPath) throws Exception {
    SparkSession spark = SparkSession.builder()
      .master("local")
      .appName("sod-challenge")
      .config("spark.executor.memory", "4g")
      .config("spark.driver.memory", "4g")
      .getOrCreate();


    Dataset<Row> df = spark.read()
      .option("header", "true")
      .option("inferSchema", "true")
      .option("timestampFormat", "MM/dd/yy'T'HH:mm")
      .option("dateFormat", "MM/dd/yy")
      .csv(inputPath);
      
      // .schema(SchemaBuilder.getSchema(new StructType()))
      // .as(Encoders.bean(SearchData.class));
      // .format("csv")
      // .load(inputPath);

    df.show();
    df.printSchema();
    df.select(col("ts_search"), col("ds_search")).show();
    }
}
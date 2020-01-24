package sod.vidalgp.challenge;

import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import static org.apache.spark.sql.functions.*;

public class DataHandler {
  static public void processData(String inputPath, String outputPath) throws Exception {
    SparkSession spark = SparkSession.builder()
      .master("local")
      .appName("sod-challenge")
      .config("spark.executor.memory", "4g")
      .config("spark.driver.memory", "4g")
      .getOrCreate();

    Dataset<Row> df = spark.read()
      .option("header", "true")
      .option("inferSchema", "true")
      .csv(inputPath);

      df.printSchema();

      Dataset<SearchData> dfSearch = SchemaFixer.fixSchema(df);
      dfSearch.printSchema();

      dfSearch.write()
              .format("parquet")
              .option("header", "true")
              .option("parquet.compression", "none")
              .save(outputPath);

    }
}
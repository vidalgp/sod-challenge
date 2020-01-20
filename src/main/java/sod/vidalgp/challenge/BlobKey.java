package sod.vidalgp.challenge;

import java.util.*;

public class BlobKey {
	private final Map<String, String> schema;
	private final String src;
	private final String dst;

	public BlobKey(String src, String dst, String schema) {
		this.src = src;
		this.dst = dst;
		this.schema = buildSchema(schema);
	}

	private Map<String, String> buildSchema(String s) {
		Map<String, String> tableSchema = new HashMap<String, String>();
		String[] fields = s.split(",");
		for (String field: fields) {
			String[] keyValue = field.split(":");
			tableSchema.put(keyValue[0], keyValue[1]);
		}
		return tableSchema;
	}

	public Map<String, String> getSchema() {
		return schema;
	}

	public String getSrc() {
		return src;
	}

	public String getDst() {
		return dst;
	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Source: " + getSrc() + "\n");
        sb.append("Output: " + getDst()+ "\n");
        sb.append("Schema: " + getSchema() + "\n");
        return sb.toString();
	}
}

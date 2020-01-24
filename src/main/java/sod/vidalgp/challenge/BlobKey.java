package sod.vidalgp.challenge;

import java.util.*;

public class BlobKey {
	private final String src;
	private final String dst;

	public BlobKey(String src, String dst) {
		this.src = src;
		this.dst = dst;
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
        return sb.toString();
	}
}

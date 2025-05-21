package com.test.WriteInTxt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import com.test.Collections.*;
import com.test.Collections.Transaction;
import com.test.annotation.FixedWidthFormatter;

public class WriteInTxt {

    // Method to write the transactions in a tabular format using streams
	public static void writeToFile(List<CombinedTransactionRecord> data, String fileName) throws IOException {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
	        if (!data.isEmpty()) {
	            writer.write(CombinedTransactionRecord.header());
	            writer.newLine();
	        }
	        for (CombinedTransactionRecord record : data) {
	            writer.write(record.toString());
	            writer.newLine();
	        }
	    }
	}

}

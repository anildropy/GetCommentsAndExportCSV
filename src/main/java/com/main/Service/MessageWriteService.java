package com.main.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.main.Model.Message;
import com.opencsv.CSVWriter;

@Service
public class MessageWriteService {

	public int write(String fileUrl, List<Message> messageList) {

		File file = new File(fileUrl);
		List<String[]> data = new ArrayList<String[]>();
		String[] firstLine = {"id","body", "postId"};

		FileWriter outputfile = null;
		try {
			outputfile = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		CSVWriter writer = new CSVWriter(outputfile);

		data.add(0,firstLine);
		for (Message m : messageList) {
			data.add(new String[] { String.valueOf(m.getId()), m.getBody(), String.valueOf(m.getPostId()) });
		}

		writer.writeAll(data);
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data.size();

	}

}

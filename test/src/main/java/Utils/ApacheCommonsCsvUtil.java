package Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.bson.types.ObjectId;
import org.springframework.web.multipart.MultipartFile;

import com.example.test.model.StockDetails;

public class ApacheCommonsCsvUtil {

	private static String csvExtension = "csv";
	
	public static List<StockDetails> parseCsvFile(InputStream is) {
		BufferedReader fileReader = null;
		CSVParser csvParser = null;

		List<StockDetails> stockDetailss = new ArrayList<StockDetails>();

		try {
			fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());

			Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			for (CSVRecord csvRecord : csvRecords) {
				StockDetails StockDetails = new StockDetails(ObjectId.get(), Integer.parseInt(csvRecord.get("quarter")), csvRecord.get("stock"),
						new SimpleDateFormat("MM/dd/yyyy").parse((csvRecord.get("date"))),
						csvRecord.get("open"), csvRecord.get("high"), csvRecord.get("low"), csvRecord.get("close"),
						csvRecord.get("percent_change_next_weeks_price"), csvRecord.get("next_weeks_close"),
						ParseDouble(csvRecord.get("volume")),
						ParseDouble(csvRecord.get("percent_change_price")), ParseDouble(csvRecord.get("percent_change_volume_over_last_wk")),
						ParseDouble(csvRecord.get("previous_weeks_volume")), ParseDouble(csvRecord.get("next_weeks_open")),
						ParseDouble(csvRecord.get("days_to_next_dividend")), ParseDouble(csvRecord.get("percent_return_next_dividend")));

				stockDetailss.add(StockDetails);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
				csvParser.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}

		return stockDetailss;
	}
	
	@SuppressWarnings("null")
	private static Double ParseDouble(String strNumber) {
		   if (strNumber != null && strNumber.length() > 0) {
		       try {
		          return Double.parseDouble(strNumber);
		       } catch(Exception e) {
		          return null;   //we want to save null, if string is null
		       }
		   }
		   else  return null;
		}
}

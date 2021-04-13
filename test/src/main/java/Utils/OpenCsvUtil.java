package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.test.model.StockDetails;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCsvUtil {

	private static String csvExtension = "csv";

	public static List<StockDetails> parseCsvFile(InputStream is) {
		String[] CSV_HEADER = { "quarter","stock","date","open","high","low","close","volume","percent_change_price","percent_change_volume_over_last_wk","previous_weeks_volume","next_weeks_open","next_weeks_close","percent_change_next_weeks_price","days_to_next_dividend","percent_return_next_dividend"};
		Reader fileReader = null;
		CsvToBean<StockDetails> csvToBean = null;
	
		List<StockDetails> stockDetailss = new ArrayList<StockDetails>();
		
		try {
			fileReader = new InputStreamReader(is);
	
			ColumnPositionMappingStrategy<StockDetails> mappingStrategy = new ColumnPositionMappingStrategy<StockDetails>();
	
			mappingStrategy.setType(StockDetails.class);
			mappingStrategy.setColumnMapping(CSV_HEADER);
	
			csvToBean = new CsvToBeanBuilder<StockDetails>(fileReader).withMappingStrategy(mappingStrategy).withSkipLines(1)
					.withIgnoreLeadingWhiteSpace(true).build();
	
			stockDetailss = csvToBean.parse();
			
			return stockDetailss;
		} catch (Exception e) {
			System.out.println("Reading CSV Error!");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Closing fileReader/csvParser Error!");
				e.printStackTrace();
			}
		}
		
		return stockDetailss;
	}
	
	public static boolean isCSVFile(MultipartFile file) {
		String extension = file.getOriginalFilename().split("\\.")[1];
		
		if(!extension.equals(csvExtension)) {
			return false;
		}
		
		return true;
	}
}

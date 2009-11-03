package com.commons.gse;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gdata.client.http.GoogleGDataRequest;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.util.ServiceException;

public class TestSheets implements Serializable {
	
	public static int counter = 0; 

 	static {
		System.setProperty(GoogleGDataRequest.DISABLE_COOKIE_HANDLER_PROPERTY, "true");
 	}

	public String getData(String compare) throws IOException, ServiceException {
		SpreadsheetService spreadsheetService = new SpreadsheetService("dispatcher-23");
		spreadsheetService.setUserCredentials("username", "password");
		URL metafeedUrl = new URL("http://spreadsheets.google.com/feeds/spreadsheets/private/full");
		SpreadsheetFeed feed = (SpreadsheetFeed) spreadsheetService.getFeed(metafeedUrl, SpreadsheetFeed.class);
		List<SpreadsheetEntry> spreadsheets = feed.getEntries();
        List<Double> values = new ArrayList<Double>();
		for (int i = 0; i < spreadsheets.size(); i++) {
			SpreadsheetEntry entry = spreadsheets.get(i);
			if (entry.getTitle().getPlainText().trim().equals("data")) {
				List<WorksheetEntry> worksheets = entry.getWorksheets();
				for (int j = 0; j < worksheets.size(); j++) {
					WorksheetEntry worksheet = worksheets.get(j);
					URL cellFeedUrl = worksheet.getCellFeedUrl();
					CellFeed cfeed = spreadsheetService.getFeed(cellFeedUrl, CellFeed.class);
					for (CellEntry cell : cfeed.getEntries()) {
						Double value = cell.getCell().getDoubleValue();
						if (cell.getTitle().getPlainText().startsWith(compare)) {
                            values.add(value);
						}
					}
				}
			}
		}
        int counter = 0;
        int max = values.size();
        StringBuilder builder = new StringBuilder();
        for (Double value : values) {
            builder.append(String.valueOf(value));
            if (++counter < max) builder.append(",");
        }
        return "http://chart.apis.google.com/chart?chxl=0:||1:|&cht=lc&chxt=x,y&chs=500x150&chco=0077CC&chm=B,E6F2FA,0,0,0&chd=t:" + builder.toString() + "&chds=4000,7000";
	}

}
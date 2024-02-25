package rahulShettyscsdemy.data;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public getJsonDataMap()
	{
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\rahulShettyscsdemy\\data\\PurchaseOrder.json"));
		//we need to add jakson databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String>>data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		
	}
}
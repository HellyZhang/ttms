package cn.tedu.ttms.common.entity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class DateFormatJson extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator json, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		json.writeString(sdf.format(date));
	}

}

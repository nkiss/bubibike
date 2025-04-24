package hu.bpbikes.bubidata.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class IntToBooleanDeserializer extends JsonDeserializer<Boolean> {

	/**
	 * Deserialize the field vale to TRUE if the field value is 1
	 */
	@Override
	public Boolean deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		Integer value = p.getIntValue();
		return value == 1;
	}

}

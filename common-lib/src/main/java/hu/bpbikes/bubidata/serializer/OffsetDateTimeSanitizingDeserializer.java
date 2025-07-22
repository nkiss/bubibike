package hu.bpbikes.bubidata.serializer;

import java.io.IOException;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OffsetDateTimeSanitizingDeserializer extends JsonDeserializer<OffsetDateTime> {

	@Override
	public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		String raw = p.getText();
		
		// Remove the redundant "Z" at the end if both "+00:00" and "Z" are present
        if (raw.endsWith("+00:00Z")) {
            raw = raw.replace("+00:00Z", "+00:00");
        }
        return OffsetDateTime.parse(raw);
	}

}

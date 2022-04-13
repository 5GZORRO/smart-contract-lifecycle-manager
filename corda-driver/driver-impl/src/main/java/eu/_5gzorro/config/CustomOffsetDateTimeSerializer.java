package eu._5gzorro.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.threeten.bp.OffsetDateTime;

import java.io.IOException;

public class CustomOffsetDateTimeSerializer extends StdSerializer<OffsetDateTime> {

    public CustomOffsetDateTimeSerializer() { this(null); }

    public CustomOffsetDateTimeSerializer(Class<OffsetDateTime> odt) { super(odt); }

    @Override
    public void serialize(OffsetDateTime odt, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        jgen.writeString(odt.toString());
    }
}

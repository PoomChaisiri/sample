package th.co.ais.internal.sample.log;

import java.util.Date;

public record LogResponse(String requestId,
                          String parserName,
                          String jsonLW,
                          String jsonResponse,
                          Long responseTimeMs,
                          Date requestDateTime,
                          Date responseDateTime,
                          String responseTimeCbsMs) {
}

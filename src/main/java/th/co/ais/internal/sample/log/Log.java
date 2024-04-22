package th.co.ais.internal.sample.log;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "NBL_DAT_QUERY_LOG_LW")
public class Log {

    @Id
    @Column(name = "REQUEST_ID", length = 30)
    private String requestId;

    @Column(name = "PARSER_NAME", length = 100)
    private String parserName;

    @Lob
    @Column(name = "JSON_LW")
    private String jsonLW;

    @Lob
    @Column(name = "JSON_RESPONSE")
    private String jsonResponse;

    @Column(name = "RESPONSE_TIME_MS")
    private Long responseTimeMs;

    @Column(name = "REQUEST_DTM")
    private Date requestDateTime;

    @Column(name = "RESPONSE_DTM")
    private Date responseDateTime;

    @Column(name = "RESPONSE_TIME_CBS_MS", length = 1000)
    private String responseTimeCbsMs;

    public LogResponse toResponse() {
        return new LogResponse(this.requestId,
                this.parserName,
                this.jsonLW,
                this.jsonResponse,
                this.responseTimeMs,
                this.requestDateTime,
                this.responseDateTime,
                this.responseTimeCbsMs);
    }
}

package com.teamsleague.infrastructure.adapter.inbound.http.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Response {

    private Object data;
}
package com.depotpay.banking.adapter.in.web;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: DongMin Kim
 */
@Schema(description = "은행 계좌 등록 요청")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterBankAccountRequest {
    
    @Schema(description = "회원 ID", example = "MEMBER001", required = true)
    private String membershipId;
    
    @Schema(description = "은행명", example = "국민은행", required = true)
    private String bankName;
    
    @Schema(description = "계좌번호", example = "123456-78-901234", required = true)
    private String bankAccountNumber;
    
    @Schema(description = "연결 상태 유효성", example = "true")
    private Boolean linkedStatusIsValid;
}

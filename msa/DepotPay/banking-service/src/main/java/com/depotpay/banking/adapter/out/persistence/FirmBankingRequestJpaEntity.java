package com.depotpay.banking.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * @author: DongMin Kim
 */
@Entity
@Table(name = "request_firmbanking")
@Data
@NoArgsConstructor
public class FirmBankingRequestJpaEntity {
    @Id
    @GeneratedValue
    private Long firmBankRequestId; // 실물계좌 요청 ID
    private String fromBankName; // 실물계좌를 요청할 은행명
    private String fromBankAccountNumber; // 실물계좌를 요청할 계좌번호
    private String toBankName; // b -> a 실물계좌로 요청을 하기 위한 Request 클래스
    private String toBankAccountNumber; // b -> a 실물계좌로 요청을
    private int moneyAmount; // 실물계좌로 요청할 금액
    private int firmBankingStatus; // 실물계좌 요청 상태
    private UUID uuid;

    public FirmBankingRequestJpaEntity(String fromBankName, String fromBankAccountNumber, String toBankName, String toBankAccountNumber, int moneyAmount, int firmBankingStatus, UUID uuid) {
        this.fromBankName = fromBankName;
        this.fromBankAccountNumber = fromBankAccountNumber;
        this.toBankName = toBankName;
        this.toBankAccountNumber = toBankAccountNumber;
        this.moneyAmount = moneyAmount;
        this.firmBankingStatus = firmBankingStatus;
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "FirmBankingRequestJpaEntity{" +
                "firmBankRequestId='" + firmBankRequestId + '\'' +
                ", formBankName='" + fromBankName + '\'' +
                ", formBankAccountNumber='" + fromBankAccountNumber + '\'' +
                ", toBankName='" + toBankName + '\'' +
                ", toBankAccountNumber='" + toBankAccountNumber + '\'' +
                ", moneyAmount=" + moneyAmount +
                ", firmBankingStatus=" + firmBankingStatus +
                ", uuid=" + uuid +
                '}';
    }
}

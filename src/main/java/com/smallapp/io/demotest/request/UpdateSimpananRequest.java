package com.smallapp.io.demotest.request;

import javax.validation.constraints.Min;

public class UpdateSimpananRequest {
    
    @Min(value = 0L, message = "The value must be positive")
    private Long withdraw;

    public Long getWithdraw() {
        return withdraw;
    }
    public void setWithdraw(Long withdraw) {
        this.withdraw = withdraw;
    }

    
}

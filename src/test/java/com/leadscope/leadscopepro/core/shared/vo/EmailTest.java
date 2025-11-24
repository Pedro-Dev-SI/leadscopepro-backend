package com.leadscope.leadscopepro.core.shared.vo;

import com.leadscope.leadscopepro.shared.vo.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {
    @Test
    void shouldNormalizeAndValidate() {
        var e = Email.of("  ADA@LeadScope.IO ");
        assertEquals("ada@leadscope.io", e.value());
    }
    @Test
    void shouldRejectInvalid() {
        assertThrows(IllegalArgumentException.class, () -> Email.of("x@"));
    }
}

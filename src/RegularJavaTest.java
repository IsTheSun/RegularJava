import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RegularJavaTest {

    @ParameterizedTest
    @ValueSource(strings = {"192.168.0.1",
            "10.0.0.154",
            "255.255.255.255",
            "172.16.0.1",
            "133.115.177.234",
            "128.0.0.0"})
    void correctIPAddress(String ip) {
        assertTrue(RegularJava.validatorIPAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"256.168.0.1",
            "xy.abc.mn.156",
            "192.168.0.01",
            "192.168.1",
            "192.168.0.1.1",
            "-1.2.3.4"})
    void incorrectIPAddress(String ip) {
        assertFalse(RegularJava.validatorIPAddress(ip));
    }

    @ParameterizedTest
    @ValueSource(strings = {"e02fd0e4-00fd-090A-ca30-0d00a0038ba0",
            "7d8e5f20-79a7-4f7f-b1c7-1576a3a63ca5",
            "87b51822-0b44-4e67-9f1f-46e6f0ca9279",
            "a21f5769-c051-45c9-8b4f-1f88c24a9900",
            "d5f940ce-6c8d-4ff7-9aeb-d3e6ccae5987",
            "f5e63b2b-17bf-47ed-ae59-e6c4f8b578f5",})
    void correctGUID(String string) {
        assertTrue(RegularJava.validatorGUID(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"7d8e5f20-79a7-4f7f-b1c7-1576a3a63ca5-",
            "87b518220b444e679f1f46e6f0ca9279",
            "3c6ab8e9-62f0-48a9-9a3e-2c03e4c2f94",
            "a21f5769-c051-45c9-8b4f-1f88c24a99-00",
            "f5e63-17bf-47ed-ae59-e6c4f8b578f5",
            "d5f940ce-6c8d76a-4ff7-9aeb-d3e6ccae5987",})
    void incorrectGUID(String string) {
        assertFalse(RegularJava.validatorGUID(string));
    }

    @ParameterizedTest
    @ValueSource(strings = {"http://www.example.com",
            "https://sub.example.co.uk:8080/path?param=value#anchor",
            "http://test-domain.com:1234/page",
            "https://www.subdomain.example.co:8000/",
            "http://long-domain-name-with-many-subdomains.example.co.uk:8888/path/to/page",
            "https://www.example.additional-domain.com:80/folder/chosen_fo?access=administrator&info=full#url5"})
    void correctURL(String address) {
        assertTrue(RegularJava.validatorURL(address));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Just Text",
            "https://123.45.67.89",
            "http://",
            "www.com",
            "www.www.com",
            "http://www.example...com",
            "www.-badwork.com",
            "http:// domain.com"})
    void incorrectURL(String address) {
        assertFalse(RegularJava.validatorURL(address));
    }

    @ParameterizedTest
    @ValueSource(strings = {"C00l_Pass1", //недостаточно доменных частей
            "GoodPss1", //ip адрес
            "2Secure3Pass", //нет доменного имени
            "Example_456", //символ "!" не допустим
            "_77Passw71", //некорректный домен
            "2003Aaaaaa" //некорректный запрос
    })
    void correctPassword(String password) {
        assertTrue(RegularJava.validatorPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Cool_pass",
            "C00l",
            "weakpassword",
            "QWERTYUIOP12",
            "1234567890",
            "P@ssw0rd_123"
    })
    void incorrectPassword(String password) {
        assertFalse(RegularJava.validatorPassword(password));
    }
}
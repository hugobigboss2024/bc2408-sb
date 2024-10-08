package com.bootcamp.demo.demo_sb_restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.mapper.JPHMapper;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.repository.UserRepository;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.util.Scheme;
import com.bootcamp.demo.demo_sb_restapi.util.Url;

@Service // Component annotation -> bean
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private Cat cat; // Vincent

  @Autowired
  private UserRepository userRepository;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring
  // Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Override
  public List<UserDTO> getUsers() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    /*
     * Url.builder() = 建造者模式：Url.builder() 是一個靜態方法，通常用於生成一個 Url
     * 對象的建造者。這種模式允許使用者逐步指定要設置的各種屬性，然後在所有配置完成後創建對象。
     * 示例：假設 Url 是一個類，builder() 方法返回一個用於構建 Url 對象的建造者。
     * 
     * scheme(Scheme.HTTPS) = 設置方案：這行代碼設置 URL 的方案（protocol），在這裡設置為 HTTPS。Scheme
     * 可能是一個枚舉或類，包含多種協議，如 HTTP 和 HTTPS。
     * 意義：這表示我們希望構建的 URL 使用安全的 HTTPS 協議。
     * 
     * domain(this.jphDomain) = 設置域名：這行代碼設置 URL 的域名部分，this.jphDomain 代表當前對象的
     * jphDomain 屬性。這個屬性應該包含一個有效的域名字符串。
     * 意義：這是 URL 中的主機名部分，通常是網站的地址。
     * 
     * endpoint(this.usersEndpoint) = 設置端點：這行代碼設置 URL 的端點部分，this.usersEndpoint
     * 可能是一個路徑字符串，指向特定的資源或服務（例如，/api/users）。
     * 意義：這是 URL 中指向特定資源的路徑部分，通常用於 API 的路由。
     * 
     * .build() = 構建 URL 對象：這行代碼調用建造者的 build() 方法，這通常會創建一個 Url 對象，並根據之前設置的屬性初始化它。
     * 意義：這個方法標誌著建造過程的結束，返回一個完整的 Url 對象。
     * 
     * toUriString() = 轉換為字符串：這行代碼調用 toUriString() 方法，這個方法將 Url 對象轉換為完整的 URL 字符串。
     * 意義：這是最終生成的 URL，可以用於發送請求或其他需要 URL 的情況。
     */
    UserDTO[] users = this.restTemplate.getForObject(url, UserDTO[].class); // 10
                                                                            // ms
    return List.of(users);
  }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<UserDTO> userDTOs = this.getUsers();
    return this.saveUsers(userDTOs);
  }

  private List<UserEntity> saveUsers(List<UserDTO> userDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = userDTOs.stream() //
        .map(e -> JPHMapper.map(e)) //
        .collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }
}
/*
 * Url.builder() = 建造者模式：Url.builder() 是一個靜態方法，通常用於生成一個 Url
 * 對象的建造者。這種模式允許使用者逐步指定要設置的各種屬性，然後在所有配置完成後創建對象。
 * 示例：假設 Url 是一個類，builder() 方法返回一個用於構建 Url 對象的建造者。
 * 
 * scheme(Scheme.HTTPS) = 設置方案：這行代碼設置 URL 的方案（protocol），在這裡設置為 HTTPS。Scheme
 * 可能是一個枚舉或類，包含多種協議，如 HTTP 和 HTTPS。
 * 意義：這表示我們希望構建的 URL 使用安全的 HTTPS 協議。
 * 
 * domain(this.jphDomain) = 設置域名：這行代碼設置 URL 的域名部分，this.jphDomain 代表當前對象的
 * jphDomain 屬性。這個屬性應該包含一個有效的域名字符串。
 * 意義：這是 URL 中的主機名部分，通常是網站的地址。
 * 
 * endpoint(this.usersEndpoint) = 設置端點：這行代碼設置 URL 的端點部分，this.usersEndpoint
 * 可能是一個路徑字符串，指向特定的資源或服務（例如，/api/users）。
 * 意義：這是 URL 中指向特定資源的路徑部分，通常用於 API 的路由。
 * 
 * .build() = 構建 URL 對象：這行代碼調用建造者的 build() 方法，這通常會創建一個 Url 對象，並根據之前設置的屬性初始化它。
 * 意義：這個方法標誌著建造過程的結束，返回一個完整的 Url 對象。
 * 
 * toUriString() = 轉換為字符串：這行代碼調用 toUriString() 方法，這個方法將 Url 對象轉換為完整的 URL 字符串。
 * 意義：這是最終生成的 URL，可以用於發送請求或其他需要 URL 的情況。
 */
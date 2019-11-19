package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {

  private String port;
  private String memoryLimit;
  private String instanceIndex;
  private String instanceAddr;

  public EnvController(@Value("${port:NOT SET}") String port, @Value("${memory.limit:NOT SET}") String memoryLimit, @Value("${cf.instance.index:NOT SET}") String instanceIndex, @Value("${cf.instance.addr:NOT SET}") String instanceAddr) {
    this.port = port;
    this.memoryLimit = memoryLimit;
    this.instanceIndex = instanceIndex;
    this.instanceAddr = instanceAddr;
  }

  @GetMapping("/env")
  public Map<String, String> getEnv() {
    Map<String, String> env = new HashMap<>();

    env.put("PORT", port);
    env.put("MEMORY_LIMIT", memoryLimit);
    env.put("CF_INSTANCE_INDEX", instanceIndex);
    env.put("CF_INSTANCE_ADDR", instanceAddr);

    return env;
  }
}

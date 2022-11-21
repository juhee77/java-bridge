package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private static final int UP = 1;
    private static final int DOWN = 0;


    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        List<String> bridge = new ArrayList<>();
        while (size-- > 0) {
            int random = bridgeNumberGenerator.generate();
            bridge.add(settingValue(random));
        }
        //System.out.println(bridge.toString());
        return bridge;
    }

    public String settingValue(int random) {
        if (random == UP) return "U";
        if (random == DOWN) return "D";
        throw new IllegalArgumentException("[ERROR] 랜덤 숫자 오류");
    }
}

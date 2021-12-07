package _02_movie.step02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }
    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if(each.isSatisFiedBy(screening)) {
                return this.getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }
    abstract protected Money getDiscountAmount(Screening screening);
}

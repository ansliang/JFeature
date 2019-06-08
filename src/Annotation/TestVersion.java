package Annotation;

@Version(
    big = 1, small = 0, name = "Tom", c = Integer.class,
    a = @Annocation1, s = Season.SPRING,
    nums = {1,2,3}, ss = {Season.SPRING, Season.SUMMER}
    )
@Annocation2({"3"})
public class TestVersion {

}

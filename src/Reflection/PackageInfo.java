package Reflection;

public class PackageInfo {
    public static void main(String[] args) {
        Package p = Package.getPackage("java.lang");
        System.out.println(p.getName());

        Package[] ps = Package.getPackages();
        for (Package p1 : ps) {
            System.out.println(p1.getName());
        }
    }
}

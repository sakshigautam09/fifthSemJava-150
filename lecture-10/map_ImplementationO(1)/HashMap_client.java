public class HashMap_client{
    public static void main(String[] args){
        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("Raj", 78);
        mp.put("Kunal", 85);
        mp.put("Ankit", 77);
        mp.put("Amisha", 68);
        mp.put("Kamlesh", 58);
        mp.put("Ankita", 68);
        mp.put("Amisha", 63);
        System.out.println(mp);
        System.out.println(mp.get("Amisha"));
    }
}
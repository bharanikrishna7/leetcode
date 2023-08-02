/*
 * @lc app=leetcode id=535 lang=java
 *
 * [535] Encode and Decode TinyURL
 */

import java.util.LinkedList;

// @lc code=start
public class Codec {
    private ArrayList<String> urls = new ArrayList<>();
    private static final String tiny_domain = "https://tinydomain.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        urls.add(longUrl);
        // System.out.println("longurl : " + longUrl + "\t key : " + urls.size());
        return tiny_domain + (urls.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index = Integer.parseInt(shortUrl.split(tiny_domain)[1]);
        // System.out.println("shorturl : "+ shortUrl + "\t index : " + index);
        return urls.get(index);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
// @lc code=end


package com.mytgbot;

import java.util.*;

public class SharedResourceManager {
    private Map<Long, SharedResource> sharedResourceMap;
    private Random random;

    public SharedResourceManager() {
        sharedResourceMap = new HashMap<>();
        random = new Random();
    }

    public void rndX(long chatId) {
        SharedResource foundSharedResource = sharedResourceMap.get(chatId);

        if (foundSharedResource == null) {
            SharedResource sharedResource = new SharedResource(random.nextInt(1000), "xxxx" + chatId);
            sharedResourceMap.put(chatId, sharedResource);
        } else {
            foundSharedResource.setX(random.nextInt(1000));
        }

    }

    public int getX(long chatId) {
        SharedResource foundSharedResource = sharedResourceMap.get(chatId);
        if (foundSharedResource == null) {
            return -1;
        } else {
            return foundSharedResource.getX();
        }
    }

    //    private List<String> strings = new ArrayList<>();
//
//    public com.mytgbot.SharedResource() {
//        random = new Random();
//        Collections.addAll(strings,
//                "aaaa",
//                "bbb",
//                "cccc",
//                "dddd");
//    }
//
//    public String getRandomString() {
//        return strings.get(random.nextInt(strings.size()));
//    }
}

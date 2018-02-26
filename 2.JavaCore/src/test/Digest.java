//1) При объявлении Map без указания типа данных, по умолчанию будет Object.
// Соответственно cache.get(input) вернет Object, и код не будет скомпилирован.
// Следует написать byte[] result = (byte[]) cache.get(input) и result = (byte[]) cache.get(input);
// НО, если в коллекции будет что-то отлично от byte[], то прилетит ClassCastException,
// даже если это маловероятно. Поэтому я бы явно убрал все в определение типов (K,V)
//
//2) При использовании synchronized блокируется вся коллекция, а так как в методе идет
// вставка и запрос объектов, то это будет работать медленно при увеличении числа потоков.
// Можно было бы использовать что-то из  java.util.concurrent.
//
//3) Синхронизация по cache.. оно не статическое, красивее было бы this
//
//
//Итого:

package test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Digest {
    private Map<byte[], byte[]> cache = new ConcurrentHashMap<>();

    public byte[] digest(byte[] input) {
        byte[] result = cache.get(input);
        if (result == null) {
            result = doDigest(input);
            cache.put(input, result);
        }
        return result;
    }

    protected abstract byte[] doDigest(byte[] input);

    public static void main(String[] args) {
        Digest digest = new Digest() {
            @Override
            protected byte[] doDigest(byte[] input) {
                return Arrays.equals(input, new byte[]{2}) ? new byte[]{1} : new byte[]{2};
            }
        };
        byte[] bytes = new byte[]{2};
        byte[] bytes1 = new byte[]{3};
        System.out.println(Arrays.toString(digest.digest(bytes)));
        System.out.println(Arrays.toString(digest.digest(bytes1)));
    }
}


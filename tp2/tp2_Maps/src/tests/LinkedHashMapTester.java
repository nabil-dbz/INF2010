package tests;

import tp2.LinkedHashMap;

public class LinkedHashMapTester {
    public static Double start (){
        double total = 0;

        total += Corrector.executeUnitTest("putReturnsNullIfNoOldValue", LinkedHashMapTester::putReturnsNullIfNoOldValue, 0.5);
        total += Corrector.executeUnitTest("putReturnsOldValue", LinkedHashMapTester::putReturnsOldValue, 1.0);

        total += Corrector.executeUnitTest("get", LinkedHashMapTester::get, 1.0);
        total += Corrector.executeUnitTest("putReplacesValue", LinkedHashMapTester::putReplacesValue, 1.0);

        total += Corrector.executeUnitTest("removeReturnsNullIfNotExist", LinkedHashMapTester::removeReturnsNullIfNotExist, 0.5);
        total += Corrector.executeUnitTest("removeReturnsRemovedValue", LinkedHashMapTester::removeReturnsRemovedValue, 1.0);

        total += Corrector.executeUnitTest("containsKey", LinkedHashMapTester::containsKey, 0.5);
        total += Corrector.executeUnitTest("isEmpty", LinkedHashMapTester::isEmpty, 1.0);

        total += Corrector.executeUnitTest("collisionsAreHandled", LinkedHashMapTester::collisionsAreHandled, 2.0);

        total += Corrector.executeUnitTest("clear", LinkedHashMapTester::clear, 0.5);

        total += Corrector.executeUnitTest("capacityIncreasesWithCompressionFactor", LinkedHashMapTester::capacityIncreasesWithCompressionFactor, 0.5);
        total += Corrector.executeUnitTest("rehashWorksProperly", LinkedHashMapTester::rehashWorksProperly, 2.0);

        return total;
    }

    public static boolean putReturnsNullIfNoOldValue(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        Integer value = map.put("myKey", 1);

        return value == null;
    }

    public static boolean get(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        Integer value = 1;
        map.put("myKey", value);
        Integer valueInMap = map.get("myKey");

        return value.equals(valueInMap);
    }

    public static boolean putReturnsOldValue(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        Integer oldValue = 1;
        map.put("myKey", oldValue);

        Integer returnedOldValue = map.put("myKey", 2);

        return oldValue.equals(returnedOldValue);
    }

    public static boolean putReplacesValue(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        Integer value = 2;
        map.put("myKey", 1);
        map.put("myKey", value);
        Integer valueInMap = map.get("myKey");

        return value.equals(valueInMap);
    }

    public static boolean removeReturnsRemovedValue(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        Integer value = 1;
        map.put("myKey", value);
        Integer removedValue = map.remove("myKey");

        return value.equals(removedValue);
    }

    public static boolean removeReturnsNullIfNotExist(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        Integer removedValue = map.remove("myKey");

        return removedValue == null;
    }

    public static boolean collisionsAreHandled(){
        LinkedHashMap<KeyMock, Integer> map = new LinkedHashMap<KeyMock, Integer>();

        System.out.println("Coucou");
        int n = 9;
        for (int i = 0; i < n ; ++i){
            String index = String.valueOf(i);
            map.put(new KeyMock("myKey" + index), i);
        }

        boolean canGetAllValues = true;
        for (int i = 0; i < n && canGetAllValues; ++i){
            String index = String.valueOf(i);
            Integer value = map.get(new KeyMock("myKey" + index));
            canGetAllValues = value != null && value.equals(i);
        }

        boolean canDetectAllKeys = true;
        for (int i = 0; i < n && canGetAllValues && canDetectAllKeys; ++i){
            String index = String.valueOf(i);
            canDetectAllKeys = map.containsKey(new KeyMock("myKey" + index));
        }

        boolean canRemoveAllValues = true;
        for (int i = 0; i < n && canGetAllValues && canDetectAllKeys && canRemoveAllValues; ++i){
            String index = String.valueOf(i);
            Integer removedValue = map.remove(new KeyMock("myKey" + index));
            canRemoveAllValues = removedValue != null && removedValue.equals(i);
        }

        return canGetAllValues && canDetectAllKeys && canRemoveAllValues;
    }

    public static boolean clear(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        int n = 9;

        for (int i = 0; i < n ; ++i){
            String index = String.valueOf(i);
            map.put("myKey" + index, i);
        }

        boolean canGetAllValues = true;
        for (int i = 0; i < n && canGetAllValues; ++i){
            String index = String.valueOf(i);
            Integer value = map.get("myKey" + index);
            canGetAllValues = value != null && value.equals(i);
        }

        map.clear();

        boolean valuesCleared = canGetAllValues;
        for (int i = 0; i < n  && valuesCleared; ++i){
            String index = String.valueOf(i);
            valuesCleared = map.get("myKey" + index) == null;
        }

        return valuesCleared;
    }

    public static boolean containsKey(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        map.put("myKey", 1);

        return map.containsKey("myKey") && !map.containsKey("unknownKey");
    }

    public static boolean isEmpty(){
        double total = 0.0;

        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

        boolean isEmptyOnEmptyMap = map.isEmpty();

        map.put("myKey", 1);

        boolean isEmptyOnFilledMap = map.isEmpty();

        map.remove("myKey");

        boolean isEmptyOnEmptiedMap = map.isEmpty();

        return isEmptyOnEmptyMap && !isEmptyOnFilledMap && isEmptyOnEmptiedMap;
    }

    public static boolean capacityIncreasesWithCompressionFactor(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(10);
        int n = 7;

        for (int i = 0; i < n ; ++i){
            String index = String.valueOf(i);
            map.put("myKey" + index, i);
        }

        return map.getCapacity() == 20;
    }

    public static boolean rehashWorksProperly(){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>(10);
        int n = 15;

        for (int i = 0; i < n ; ++i){
            String index = String.valueOf(i);
            map.put("myKey" + index, i);
        }

        boolean rehashWorks = true;
        for (int i = 0; i <  n && rehashWorks; ++i){
            String index = String.valueOf(i);
            Integer value = map.get("myKey" + index);
            rehashWorks = value != null ? map.get("myKey" + index) == i : false;
        }

        return rehashWorks;
    }

    static class KeyMock {
        private String key;

        public KeyMock(String key){
            this.key = key;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object other)
        {
            boolean isEqual = false;

            if (other != null && other instanceof KeyMock)
            {
                KeyMock otherKey = (KeyMock) other;
                isEqual = key.equals(otherKey.key);
            }

            return isEqual;
        }
    }
}

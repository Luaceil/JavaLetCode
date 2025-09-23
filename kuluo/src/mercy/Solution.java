package mercy;

import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
1.某项目正在开发一个线程安全的商品库存管理系统,系统需要实现Solution类中的以下方法:
void AddProduct(String productld, int amount)//添加新的商品和库存量。果商品ID已经存在,应该更新库存量。
void SellProduct(String productld, intamount)//销售商品。如果库存不足,应抛出库存不足异常。
int GetAmount(String productld) //根据商品ID获取商品的库存。
具体要求:
1、所有操作必须是线程安全的,支持并发的商品销售和库存更新操作
2、当销售某商品时,应减少相应数量库存。如果库存不足,应抛出一个自定义的库存不足异常 InsufficientStockException
3、更新商品库存时,如果库存小于0, 应抛出一个自定义的无效库存异常 InvalidStockException
 */
class InsufficientStockException extends Exception{
   public InsufficientStockException(String message) {
       super(message);
   }
}
class InvalidStockException extends Exception{
    public InvalidStockException(String message) {
                super(message);
    }
}
public class Solution {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public HashMap<String,ReadWriteLock> lockHashMap =new HashMap<>();
    public HashMap<String,Integer> stageMap=new HashMap<>();
    void AddProduct(String productld, int amount) throws  InvalidStockException {
        if(!lockHashMap.containsKey(productld)){
            final ReadWriteLock lock=new  ReentrantReadWriteLock();
            lockHashMap.put(productld,lock);
            stageMap.put(productld,amount);
        }else {
            ReadWriteLock lock = lockHashMap.get(productld);
            while(!lock.writeLock().tryLock()){}
                stageMap.merge(productld,1,Integer::sum);
        }
    }
    void SellProduct(String productld, int amount) throws Exception {
        if(!lockHashMap.containsKey(productld)){
            throw new InsufficientStockException("s");
        }
    }
    int GetAmount(String productld){
        return 1;
    }
}

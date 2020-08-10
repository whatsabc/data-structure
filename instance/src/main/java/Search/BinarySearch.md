作者：labuladong

链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/

来源：力扣（LeetCode）

著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 1 二分法查找框架

```java
int binarySearch(int[] nums, int target) {
    int left = 0, right = ...;

    while(...) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            ...
        } else if (nums[mid] < target) {
            left = ...
        } else if (nums[mid] > target) {
            right = ...
        }
    }
    return ...;
}
```
#### 为什么 while 循环的条件中是 <=，而不是 <？

因为初始化right的赋值是nums.length-1，即最后一个元素的索引，而不是nums.length。

这二者可能出现在不同功能的二分查找中，区别是：前者相当于两端都闭区间`[left,right]`，后者相当于左闭右开区间`[left,right)`，因为索引大小为nums.length是越界的。

我们这个算法中使用的是前者`[left,right]`两端都闭的区间。这个区间其实就是每次进行搜索的区间。找到了目标值的时候可以终止：
```
if(nums[mid] == target)
    return mid; 
```

`while(left<=right)`的终止条件是`left==right+1`，写成区间的形式就是`[right+1,right]`，或者带个具体的数字进去`[3,2]`，可见这时候区间为空，因为没有数字既大于等于3又小于等于2的吧。所以这时候while循环终止是正确的，直接返回-1即可。

`while(left<right)`的终止条件是`left==right`，写成区间的形式就是`[left,right]`，或者带个具体的数字进去`[2,2]`，这时候区间非空，还有一个数2，但此时while循环终止了。也就是说这区间`[2,2]`被漏掉了，索引2没有被搜索，如果这时候直接返回-1就是错误的。

#### 此算法有什么缺陷？
     
这个算法存在局限性。比如说给你有序数组`nums=[1,2,2,2,3]`，target为2，此算法返回的索引是2，没错。但是如果我想得到target的左侧边界，即索引1，或者我想得到target的右侧边界，即索引3，这样的话此算法是无法处理的。
     
这样的需求很常见，你也许会说，找到一个target，然后向左或向右线性搜索不行吗？可以，但是不好，因为这样难以保证二分查找对数级的复杂度了。

## 2 寻找左侧边界的二分搜索

```java
int left_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0;
    int right = nums.length; // 注意
    
    while (left < right) { // 注意
        int mid =left + (right-left) / 2;
        if (nums[mid] == target) {
            right = mid;
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid; // 注意
        }
    }
    return left;
}
```

#### 为什么 left = mid + 1，right = mid ？和之前的算法不一样？

因为我们的「搜索区间」是`[left, right)`左闭右开，所以当`nums[mid]`被检测之后，下一步的搜索区间应该去掉mid分割成两个区间，即`[left, mid)`或`[mid + 1, right)`

## 3 寻找右侧边界的二分查找

```java
int right_bound(int[] nums, int target) {
    if (nums.length == 0) return -1;
    int left = 0, right = nums.length;
    
    while (left < right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            left = mid + 1; // 使区间向右收缩，达到锁定右边界的目的
        } else if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid;
        }
    }
    return right - 1; // 注意，结束循环时left=right，因此left-1也可以
}
```

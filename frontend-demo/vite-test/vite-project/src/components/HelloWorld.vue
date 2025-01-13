<script type="module" setup>

    //引入模块
    import { reactive} from 'vue'
    //准备购物车数据,设置成响应数据
    const carts = reactive([{name:'可乐',price:3,number:10},{name:'薯片',price:6,number:8}])

    //计算购物车总金额
    function compute(){
      let count = 0;
      for(let index in carts){
        count += carts[index].price*carts[index].number;
      }
      return count;
    }
    //删除购物项方法
    function removeCart(index){
      carts.splice(index,1);
    }
    
</script>

<template>
    <div>
        <table>
           <thead>
               <tr>
                  <th>序号</th>
                  <th>商品名</th>
                  <th>价格</th>
                  <th>数量</th>
                  <th>小计</th>
                  <th>操作</th>
               </tr>
           </thead>
           <tbody v-if="carts.length > 0">
               <!-- 有数据显示-->
               <tr v-for="cart,index in carts" :key="index">
                  <th>{{ index+1 }}</th>
                  <th>{{ cart.name }}</th>
                  <th>{{ cart.price + '元' }}</th>
                  <th>{{ cart.number }}</th>
                  <th>{{ cart.price*cart.number  + '元'}}</th>
                  <th> <button @click="removeCart(index)">删除</button> </th>
               </tr>
           </tbody>
           <tbody v-else>
               <!-- 没有数据显示-->
               <tr>
                  <td colspan="6">购物车没有数据!</td>
               </tr>
           </tbody>
        </table>
        购物车总金额: {{ compute() }} 元
    </div>
</template> 

<style scoped>
</style>
/**
 * Created by Dai on 6/19/16.
 */
'use strict';
rangerApp.filter('orderformStateFilter', function(){
    var filter = function(inputArray, state){
        if(state > 0){
            var array = [];
            for(var i = 0; i < inputArray.length; i++){
                if(inputArray[i].orderform.state == state){
                    array.push(inputArray[i]);
                }
            }
            console.log(array);
            return array;
        }else{
            return inputArray;
        }
    };
    return filter;
});

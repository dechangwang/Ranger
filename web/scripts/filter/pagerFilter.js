/**
 * Created by Dai on 6/20/16.
 */
'use strict';
rangerApp.filter('pagerFilter', function(){
    var filter = function(inputArray, currentPage, pageSize){
        var array = [];
        // console.log(inputArray);
        // console.log(currentPage);
        // console.log(pageSize);
        for(var i = 0; i < inputArray.length; i++){
            if(i > (currentPage-1)*pageSize -1 && i < currentPage*pageSize){
                array.push(inputArray[i]);
            }
        }
        return array;
    };
    return filter;
});
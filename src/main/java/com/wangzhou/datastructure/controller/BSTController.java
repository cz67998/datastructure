package com.wangzhou.datastructure.controller;

import com.wangzhou.datastructure.mytree.binarytree.BST;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IDEA
 * author:wangzhou
 * Date:2019/5/29
 * Time:9:07
 **/
@Controller
@RequestMapping("bst")
public class BSTController {
    @GetMapping
    @ResponseBody
    public BST bst() {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);
        System.out.println(bst);
        return bst;
    }
}

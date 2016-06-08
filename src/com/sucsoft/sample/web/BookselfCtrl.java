package com.sucsoft.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sucsoft.sample.entity.Bookself;

@Controller
@RequestMapping("/bookself")
public class BookselfCtrl extends BaseCtrl<Bookself> {
}

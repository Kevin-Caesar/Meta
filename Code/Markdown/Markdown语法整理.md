#! https://zhuanlan.zhihu.com/p/556231725
- [Markdown语法整理](#markdown语法整理)
  - [代码块 Code Block](#代码块-code-block)
  - [区块引用 Blockquote](#区块引用-blockquote)
  - [链接 Link](#链接-link)
    - [网页链接](#网页链接)
    - [图片链接](#图片链接)
    - [自动链接](#自动链接)
    - [编号链接{#1}](#编号链接1)
  - [表格 Table](#表格-table)
  - [代办 Todo](#代办-todo)
  - [表情 Emoji](#表情-emoji)

# Markdown语法整理

主要涉及部分难点语法和非常用语法

## 代码块 Code Block

要在 Markdown 中建立代码区块很简单，只要简单地缩进 4 个空格或是 1 个制表符就可以。亦可使用围栏符号(```/~~~)创建代码块，支持语法高亮。

- 缩进式：
  
        public void test() {
        } 

        This is a Code Block.

  实际效果：

      public void test() {
      } 

      This is a Code Block.
- 围栏式：

      ```java
      public void test() {

      } 
      ```

  实际效果：

  ```java
  public void test() {

  } 
  ```

- 内联式：
  
      Use the `printf()` function.

  实际效果：

  Use the `printf()` function.

## 区块引用 Blockquote

区块引用用于展示引言的格式的文体，支持嵌套引用，并可使用其他Markdown语法。示例：

    > ### 这是一个标题
    >
    > 1. 这是第一行列表项。
    > 2. 这是第二行列表项。
    >
    > 给出一些例子代码（代码块）：
    >
    >     return shell_exec("echo $input | $markdown_script");
    > This is the first level of quoting(嵌套引用).
    >
    > > This is nested blockquote.
    >
    > Back to the first level.

  实际效果：

> ### 这是一个标题
>
> 1. 这是第一行列表项。
> 2. 这是第二行列表项。
>
> 给出一些例子代码（代码块）：
>
>     return shell_exec("echo $input | $markdown_script");
> This is the first level of quoting(嵌套引用).
>
> > This is nested blockquote.
>
> Back to the first level.

## 链接 Link

Markdown 支持两种形式的链接语法： 行内式和参考式两种形式。

### 网页链接

- 行内式：
  
      This is [an example](http://example.com/ "Title") inline link

      [This link](http://example.net/) has no title attribute.

      See my [About](/about/) page for details.

      I get 10 times more traffic from [Google](http://google.com/ "Google") than from [Yahoo](http://search.yahoo.com/ "Yahoo Search") or [MSN](http://search.msn.com/ "MSN Search").
  
  实际效果：

  This is [an example](http://example.com/ "Title") inline link

  [This link](http://example.net/) has no title attribute.

  See my [About](/about/) page for details.

  I get 10 times more traffic from [Google](http://google.com/ "Google") than from [Yahoo](http://search.yahoo.com/ "Yahoo Search") or [MSN](http://search.msn.com/ "MSN Search").

- 参考式

      I get 10 times more traffic from [Google] [1] than from
      [Yahoo] [2] or [MSN] [3].

        [1]: http://google.com/        "Google"
        [2]: http://search.yahoo.com/  "Yahoo Search"
        [3]: http://search.msn.com/    "MSN Search"

      I get 10 times more traffic from [Google][] than from
      [Yahoo][] or [MSN][].

        [google]: http://google.com/        "Google"
        [yahoo]:  http://search.yahoo.com/  "Yahoo Search"
        [msn]:    http://search.msn.com/    "MSN Search"

  实际效果：
  I get 10 times more traffic from [Google] [1] than from
  [Yahoo] [2] or [MSN] [3].

    [1]: http://google.com/        "Google"
    [2]: http://search.yahoo.com/  "Yahoo Search"
    [3]: http://search.msn.com/    "MSN Search"

  I get 10 times more traffic from [Google][] than from
  [Yahoo][] or [MSN][].

    [google]: http://google.com/        "Google"
    [yahoo]:  http://search.yahoo.com/  "Yahoo Search"
    [msn]:    http://search.msn.com/    "MSN Search"

### 图片链接

- 参考式

      ![Alt text](/path/to/img.jpg)

      ![Alt text](/path/to/img.jpg "Optional title")

      ![Alt text][id]

  实际效果：

  ![Alt text](https://pic.qqtn.com/up/2017-7/2017071317523053609.jpg)

  ![Alt text](https://scpic.chinaz.net/files/pic/pic9/202009/apic27858.jpg "Optional title")

  ![Alt text][id]
  
[id]: https://pic3.zhimg.com/v2-58d652598269710fa67ec8d1c88d8f03_r.jpg?source=1940ef5c "Optional title attribute"

### 自动链接

Markdown 支持以比较简短的自动链接形式来处理网址和电子邮件信箱，只要是用尖括号包起来， Markdown 就会自动把它转成链接。一般网址的链接文字就和链接地址一样，示例：

    <address@example.com>
    http://www.example.com
    禁用自动连接：`http://www.example.com`

  实际效果

<address@example.com>

<http://www.example.com>

### 编号链接{#1}

用于TOC，示例：

    [header](#134-编号链接1)
  
  实际效果：
  
  [header](#134-编号链接1)

## 表格 Table

要添加表，请使用三个或多个连字符（---）创建每列的标题，并使用管道（|）分隔每列。可以选择在表的任一端添加管道，同时可以通过在标题行中的连字符的左侧，右侧或两侧添加冒号（:），将列中的文本对齐到左侧，右侧或中心。示例：

    | Syntax                       |    Description    |       Test Text |
    |:-----------------------------|:-----------------:|----------------:|
    | `Header`                     |      *Title*      | **Here's this** |
    | [Paragraph](Demo.md "title") | <address@ext.com> |    ~~And more~~ |

  实际效果：

| Syntax                       |    Description    |       Test Text |
|:-----------------------------|:-----------------:|----------------:|
| `Header`                     |      *Title*      | **Here's this** |
| [Paragraph](Demo.md "title") | <address@ext.com> |    ~~And more~~ |

## 代办 Todo

    - [x] Write the press release
    - [ ] Update the website
    - [ ] Contact the media

  实际效果：
  
- [x] Write the press release
- [ ] Update the website
- [ ] Contact the media

## 表情 Emoji

    去露营了！:tent: 很快回来。

    真好笑！ :joy:
  
  实际效果：

  去露营了！:tent: 很快回来。

  真好笑！ :joy:

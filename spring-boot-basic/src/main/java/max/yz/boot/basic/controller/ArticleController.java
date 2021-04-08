package max.yz.boot.basic.controller;

import lombok.extern.slf4j.Slf4j;
import max.yz.boot.basic.controller.dto.AjaxResponse;
import max.yz.boot.basic.entity.Article;
import max.yz.boot.basic.entity.ArticleReader;
import max.yz.boot.basic.service.ArticleService;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author imyizai
 * @ClassName ArticleController
 * @Description
 * @Date 2021/3/11 7:37 下午
 **/

@RestController
@RequestMapping(value = "api/v1/articles")
@Slf4j
//@Api(tags = "文章管理接口")
@Validated
public class ArticleController {
    @Resource
    private ArticleService articleService;

    private MockMultipartFile multipartFile;

    //创建线程安全的Map，模拟articles信息的存储
    static Map<Integer, Article> articles = Collections.synchronizedMap(new HashMap<>());

    /** 获取一篇Article，使用GET方法，根据id查询一篇文章，路径参数 ...*/

//    public AjaxResponse getArticleByParam(@ApiParam("文章id") @RequestParam("id") int id) {}

    /** 查询所有文章 ...*/
    @GetMapping("all")
    public AjaxResponse selectArticles() {
        List<Article> articleList = articleService.getAll();
        ArticleReader[] readers = {
                ArticleReader.builder()
                        .name("ddd")
                        .age(20)
                        .build(),
                ArticleReader.builder()
                        .name("fff")
                        .age(25)
                        .build(),
        };
        List<ArticleReader> readerList = Arrays.asList(readers);// 数组成集合
        Article article1 = Article.builder()
                .id(123)
                .author("yz")
                .title("SpringBoot")
                .content("SpringBoot从入门到进阶")
                .updateTime(new Date())
//                .readers(readerList)
                .build();

        Article article2 = Article.builder()
                .id(456)
                .author("yz")
                .title("Vue.js")
                .content("Vue.js从入门到进阶")
                .updateTime(new Date())
//                .readers(readerList)
                .build();
        Article[] articles = {article1, article2};
        List<Article> articlelist = Arrays.asList(articles);
        return AjaxResponse.success(articleList);
    }

    /** 增加一首Article，@RequestBody接受参数 ...*/

    @GetMapping("{id}")//路径传参
    public AjaxResponse getArticle(@PathVariable int id) {
        Article article = Article.builder()
                .id(id)
                .author("yz")
                .title("java")
                .content("java")
                .updateTime(new Date())
                .build();
        return AjaxResponse.success(article);
    }


    /** 增加一篇Article , @RequestBody接受参数 ...*/
    @PostMapping()
    public AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle:" + article);
//        articles.put(article.getId(),article);
        boolean flag = articleService.postArticle(article);
        return AjaxResponse.success(article);
    }

    @PutMapping() //修改,通过问号传参
//    @ApiImplcitParm(paramType = "path",dataType = "Integer", name = "id", value = "文章编号", required = true)
//    @ApiOperation(value = "更新文章信息", notes = "根据路径参数id来指定更新文章对象，并根据入参article对象来更新文章详细信息")

    public AjaxResponse updateArticle(@RequestBody Article article) {
        boolean updateArticle = articleService.updateArticle(article);
        return AjaxResponse.success(updateArticle);
    }

    /** 删除一篇Article，使用DELETE方法，参数是id ...*/
    @DeleteMapping("{id}")
    public AjaxResponse deleteArticle(@PathVariable int id, String title) {
        log.info("deleteArticle:" + id);
        articleService.deleteArticle(id);
        return AjaxResponse.success();
    }



    @PostMapping("upload")
    public AjaxResponse handleUpload(MultipartFile file, HttpServletRequest request) {
        //创建文件在服务器的存放目录
        String path = request.getServletContext().getRealPath("/upload");
        log.info(path);
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            boolean flag = fileDir.mkdirs();
            log.info("flag:" + flag);

        }
        //生成文件在服务器的名字
        String prefixName=UUID.randomUUID().toString();
        //取得原文件的后缀名
        String originalFilename=file.getOriginalFilename();
        //从原文件名中分离出扩展名(后缀) 111.jpg->.jpg
        assert  originalFilename !=null;
        String suffixName=originalFilename.substring(originalFilename.lastIndexOf("."));
        //拼接新的文件名
        String fileName=prefixName+suffixName;
        log.info(fileName);
        //创建上传文件对象
        File saveFile=new File(path+"/"+fileName);
        //上传
        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            log.info(e.getMessage());
            AjaxResponse.failure("文件上传失败");
        }
        return AjaxResponse.success(fileName);
    }

    @PostMapping(value = "/upload2")
    public AjaxResponse sourceUpload(MultipartFile[] sourceFiles, HttpServletRequest request) {
        List fileNames = new ArrayList();
        YearMonth yearMonth = YearMonth.now();
        Calendar now = Calendar.getInstance();
        for(MultipartFile file :sourceFiles) {
            if(file.isEmpty()) {
                System.out.println("文件为空");
            }

            //文件重命名
            String prefixName1 = UUID.randomUUID().toString();
            //获取文件后缀名
            String originalFilename = file.getOriginalFilename();
            //
            assert originalFilename != null;
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            //拼接新的文件名
            String newFileName = prefixName1 + suffixName;
            log.info(newFileName);
            //上传文件
            String ym = yearMonth.format(DateTimeFormatter.ofPattern("yyyy-MM"));
            int day = now.get(Calendar.DAY_OF_MONTH);
            String path = request.getServletContext().getRealPath("img/"+ym+"/"+ day + "/" + suffixName);
            log.info(path);
            File fileDir = new File(path);
            if (!fileDir.exists()){
                boolean flag = fileDir.mkdirs();
                log.info("flag:"+flag);
            }
            //创建上传文件对象
            File saveFile = new File(path + "/" + newFileName);
            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
                log.info(e.getMessage());
                AjaxResponse.failure("文件上传失败");
            }
            fileNames.add(newFileName);
            log.info(fileNames.toString());
        }
        return AjaxResponse.success(fileNames);
    }
}



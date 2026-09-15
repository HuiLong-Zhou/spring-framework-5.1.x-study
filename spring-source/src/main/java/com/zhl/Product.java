package com.zhl;

/**
 * ClassName: Product
 * Package: com.zhl
 * Description <p/>
 *
 * @author zhl
 * @Create 2024-05-06 21:26
 * version 1.0
 */
public class Product {
        private String name;
        private Integer id;


        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        @Override
        public String toString() {
                return "Product{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
}

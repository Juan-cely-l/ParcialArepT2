package org.example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MathService {

    public Integer linearSearch(List<Integer> list, Integer value) {
        for (int num : list) {
            if (num == value) {
                return list.indexOf(num);
            }

        }
        return -1;
    }

    public static String binarysearch(List<Integer> list, Integer value) {
        Integer inicio = 0;
        Integer fin = list.size() - 1;

        while (inicio <= fin) {
            Integer medio = inicio + (fin - inicio) / 2;

            if (Objects.equals(list.get(medio), value)) {
                return medio.toString();
            } else if (list.get(medio) < value) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return "-1";


    }
}



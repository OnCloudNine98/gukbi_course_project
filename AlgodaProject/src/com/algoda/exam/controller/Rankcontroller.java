package com.algoda.exam.controller;

import com.algoda.member.model.Memberdao;
import com.algoda.member.model.Memberdto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

@WebServlet("/rank.do")
public class Rankcontroller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Rankcontroller() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Memberdao memberdao = new Memberdao();
        List<Memberdto> memberdtoList;
        List<Rankdto> rankdtoList = new ArrayList<Rankdto>();
        int level = Integer.parseInt(req.getParameter("level"));

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("id");
        String section = "미정";
        memberdtoList = memberdao.listMember();

        if (level == 1) {
            for (Memberdto member : memberdtoList) {
                Rankdto rankdto = new Rankdto();
                rankdto.setId(member.getId());
                rankdto.setName(member.getName());
                rankdto.setScore((float) (Math.round((float) member.getScorea() / member.getAcount() * 100) / 100.0));
                rankdto.setCount(member.getAcount());

                rankdtoList.add(rankdto);
            }
            Collections.sort(rankdtoList, new RankScoreComparator().reversed());
            section = "중등 영단어";
        } else if (level == 2) {
            for (Memberdto member : memberdtoList) {
                Rankdto rankdto = new Rankdto();
                rankdto.setId(member.getId());
                rankdto.setName(member.getName());
                rankdto.setScore((float) (Math.round((float) member.getScoreb() / member.getBcount() * 100) / 100.0));
                rankdto.setCount(member.getBcount());

                rankdtoList.add(rankdto);
            }
            Collections.sort(rankdtoList, new RankScoreComparator().reversed());
            section = "수능 영단어";
        } else if (level == 3) {
            for (Memberdto member : memberdtoList) {
                Rankdto rankdto = new Rankdto();
                rankdto.setId(member.getId());
                rankdto.setName(member.getName());
                rankdto.setScore((float) (Math.round((float) member.getScorec() / member.getCcount() * 100) / 100.0));
                rankdto.setCount(member.getCcount());

                rankdtoList.add(rankdto);
            }
            Collections.sort(rankdtoList, new RankScoreComparator().reversed());
            section = "직장인 영단어";
        }
        System.out.print("정렬된 후 의 arrList : ");
        Iterator<Rankdto> iter = rankdtoList.iterator();

        req.setAttribute("section", section);
        req.setAttribute("level", level);
        req.setAttribute("id", id);
        req.setAttribute("ranklist", rankdtoList);
        req.getRequestDispatcher("/rank/Ranking.jsp").forward(req, resp);
    }
}

class RankScoreComparator implements Comparator<Rankdto> {
    @Override
    public int compare(Rankdto f1, Rankdto f2) {
        if (Float.compare(f1.getScore(), f2.getScore()) > 0) {
            return 1;
        } else if (Float.compare(f1.getScore(), f2.getScore()) < 0) {
            return -1;
        }
        return 0;
    }
}

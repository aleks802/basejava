package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void doSave(Resume resume, Resume res) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Resume resume, Resume res) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected boolean isExist(Resume res) {
        return res != null;
    }

    @Override
    protected void doDelete(Resume res) {
        map.remove(res.getUuid());
    }

    @Override
    protected Resume doGet(Resume res) {
        return res;
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
